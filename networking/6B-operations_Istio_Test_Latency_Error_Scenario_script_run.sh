echo "                        "
echo "------------------ Start Mesh Latency Error Testing/Data loading scripts --------------------------"


echo "                        "
echo "-----------------kubectl delete deployment zookeeper -n kafka-ca1 ---------------------------"
kubectl delete service kafka -n kafka-ca1

echo "------------------ sleep 20s --------------------------"
sleep 20s



echo "                        "


for((i=1;i<=2;i++)); do 

echo "-----------------kyc-aggregator-mgt  to credit-check/basic - generates 10s latency due to Kafka unavailability ---------------------------"
kubectl exec "$(kubectl get pod -l app=kyc-aggregator-mgt -n consumer -o jsonpath={.items..metadata.name})" -c kyc-aggregator-mgt -n consumer -- curl http://kyc-credit-check-basic.basic:8080/credit-check/basic -s -o /dev/null -w "%{http_code}\n"; 

echo "-----------------kyc-aggregator-mgt  to credit-check/advanced  - working as expected scenario ---------------------------"
kubectl exec "$(kubectl get pod -l app=kyc-aggregator-mgt -n consumer -o jsonpath={.items..metadata.name})" -c kyc-aggregator-mgt -n consumer -- curl http://kyc-credit-check-advanced.advanced:8080/credit-check/advanced -s -o /dev/null -w "%{http_code}\n"


done


echo "                        "
echo "------------------ repeat the script run if you need more test data --------------------------"










