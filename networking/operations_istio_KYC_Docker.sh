cd  /c/Vijay/Java/projects/kyc-k8-docker-istio/kyc-aggregator-mgt
echo "------------------docker rmi--------------------------"
docker rmi kyc-aggregator-mgt:latest
echo "------------------docker rmi--------------------------"
docker rmi -f kyc-aggregator-mgt:latest | docker rmi -f vijayredkar/kyc-aggregator-mgt:latest
echo "------------------mvn clean install--------------------------"
mvn clean install
echo "------------------docker build kyc-aggregator-mgt--------------------------"
docker build -t kyc-aggregator-mgt -f Dockerfile .
echo "------------------docker image ls--------------------------"
docker image ls
echo "------------------docker tag--------------------------"
docker tag  kyc-aggregator-mgt vijayredkar/kyc-aggregator-mgt:latest
echo "------------------docker push--------------------------"
docker push vijayredkar/kyc-aggregator-mgt





cd  /c/Vijay/Java/projects/kyc-k8-docker-istio/kyc-credit-check-basic
echo "------------------docker rmi--------------------------"
docker rmi kyc-credit-check-basic:latest
echo "------------------docker rmi--------------------------"
docker rmi -f kyc-credit-check-basic:latest | docker rmi -f vijayredkar/kyc-credit-check-basic:latest
echo "------------------mvn clean install--------------------------"
mvn clean install
echo "------------------docker build kyc-credit-check-basic--------------------------"
docker build -t kyc-credit-check-basic -f Dockerfile .
echo "------------------docker image ls--------------------------"
docker image ls
echo "------------------docker tag--------------------------"
docker tag  kyc-credit-check-basic vijayredkar/kyc-credit-check-basic:latest
echo "------------------docker push--------------------------"
docker push vijayredkar/kyc-credit-check-basic




cd  /c/Vijay/Java/projects/kyc-k8-docker-istio/kyc-credit-check-advanced
echo "------------------docker rmi--------------------------"
docker rmi kyc-credit-check-advanced:latest
echo "------------------docker rmi--------------------------"
docker rmi -f kyc-credit-check-advanced:latest | docker rmi -f vijayredkar/kyc-credit-check-advanced:latest
echo "------------------mvn clean install--------------------------"
mvn clean install
echo "------------------docker build kyc-credit-check-advanced--------------------------"
docker build -t kyc-credit-check-advanced -f Dockerfile .
echo "------------------docker image ls--------------------------"
docker image ls
echo "------------------docker tag--------------------------"
docker tag  kyc-credit-check-advanced vijayredkar/kyc-credit-check-advanced:latest
echo "------------------docker push--------------------------"
docker push vijayredkar/kyc-credit-check-advanced
