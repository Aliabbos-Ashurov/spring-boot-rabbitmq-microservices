# shellcheck disable=SC2046
export $(cat .env | xargs)

docker run -d \
  --name rabbitmq-container \
  -p ${RABBIT_AMQ_PORT:-5672}:5672 \
  -p ${RABBIT_MANAGEMENT_PORT:-15672}:15672 \
  -e RABBITMQ_DEFAULT_USER=${RABBIT_MQ_USER:-admin} \
  -e RABBITMQ_DEFAULT_PASS=${RABBIT_MQ_PASSWORD:-password} \
  rabbitmq:latest

docker exec -it rabbitmq-container rabbitmq-plugins enable rabbitmq_management
