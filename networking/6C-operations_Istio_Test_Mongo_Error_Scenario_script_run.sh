echo "                        "
echo "------------------ Start Mesh Error Testing/Data loading scripts --------------------------"



echo "                        "
echo "-----------------kyc-aggregator-mgt  to credit-check/advanced  - generate Mongo error ---------------------------"
for((i=1;i<=3;i++)); do 
kubectl exec "$(kubectl get pod -l app=kyc-aggregator-mgt -n consumer -o jsonpath={.items..metadata.name})" -c kyc-aggregator-mgt -n consumer -- curl http://kyc-credit-check-advanced.advanced:8080/credit-check/advanced?triggerMongoError=Y -s -o /dev/null -w "%{http_code}\n"
done
echo "                        "
echo "------------------ repeat the script run if you need more test data --------------------------"



