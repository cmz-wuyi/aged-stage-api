#!/usr/bin/env bash

#deploy.sh
#GIT_URL=git@gitee.com:Doubs/poverty-help.git
#GIT_APP_NAME=poverty-help
#ARTIFACT_ID=poverty-help-api
#MAVEN_HOME=/opt/maven/apache-maven-3.8.3
#EVN=$1

GIT_URL=$1
GIT_APP_NAME=$2
ARTIFACT_ID=$3
EVN=$4
MAVEN_HOME=/opt/maven/apache-maven-3.8.3


# 执行发布方法
deploy(){
  echo "----------------------------删除旧项目--------------------------------------------"
  rm -rf /opt/${GIT_APP_NAME}/
  rm -rf /opt/${ARTIFACT_ID}.tar.gz
  rm -rf /opt/${ARTIFACT_ID}/
  if [ $? -ne 0 ]; then
    echo "----------------------------删除旧项目->结束-failed--------------------------------------------"
  else
    echo "----------------------------删除旧项目->结束-succeed--------------------------------------------"
  fi
  echo "----------------------------clone项目--------------------------------------------"
  git clone -b dev ${GIT_URL} /opt/${GIT_APP_NAME}/
  if [ $? -ne 0 ]; then
    echo "----------------------------clone项目->结束-failed--------------------------------------------"
  else
    echo "----------------------------clone项目->结束-succeed--------------------------------------------"
  fi
  echo "----------------------------执行打包--------------------------------------------"
  cd /opt/${GIT_APP_NAME}/${ARTIFACT_ID}
  mvn clean package -Dmaven.test.skip=true --settings ${MAVEN_HOME}/conf/settings.xml
  if [ $? -ne 0 ]; then
    echo "----------------------------执行打包->结束-failed--------------------------------------------"
  else
    echo "----------------------------执行打包->结束-succeed--------------------------------------------"
  fi
  echo "----------------------------准备启动--------------------------------------------"
  mv /opt/${GIT_APP_NAME}/${ARTIFACT_ID}/${ARTIFACT_ID}.tar.gz /opt/${ARTIFACT_ID}.tar.gz
  mkdir /opt/${ARTIFACT_ID}/
  if [ $? -ne 0 ]; then
    echo "----------------------------准备启动->结束-failed--------------------------------------------"
  else
    echo "----------------------------准备启动->结束-succeed--------------------------------------------"
  fi
  echo "----------------------------解压文件--------------------------------------------"
  tar -zxvf /opt/${ARTIFACT_ID}.tar.gz -C /opt/
  if [ $? -ne 0 ]; then
    echo "----------------------------解压文件->结束-failed--------------------------------------------"
  else
    echo "----------------------------解压文件->结束-succeed--------------------------------------------"
  fi
  echo "----------------------------启动项目--------------------------------------------"
  cd /opt/${ARTIFACT_ID}
  sh sbin/startup.sh ${EVN}
  if [ $? -ne 0 ]; then
    echo "----------------------------启动项目->结束-failed--------------------------------------------"
  else
    echo "----------------------------启动项目->结束-succeed--------------------------------------------"
  fi
}

deploy
