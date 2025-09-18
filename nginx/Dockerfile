#nginx를 image화하기위한 전용도커

#리눅스 환경에 nginx세팅할 기본환경 가져옴
FROM nginx:1.29.1-alpine

COPY ./myconfig1.conf /etc/nginx/conf.d/myconfig1.conf
RUN rm /etc/nginx/conf.d/default.conf

#80번포트에 열어둠. 이 nginx를
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]