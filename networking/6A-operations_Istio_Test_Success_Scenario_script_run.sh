echo "                        "
echo "------------------ Start Mesh Test data load - Success scenario --------------------------"

echo "                        "
echo "-----------------kyc-aggregator-mgt  to credit-check/basic---------------------------"
for((i=1;i<=3;i++)); do 
kubectl exec "$(kubectl get pod -l app=kyc-aggregator-mgt -n consumer -o jsonpath={.items..metadata.name})" -c kyc-aggregator-mgt -n consumer -- curl http://kyc-credit-check-basic.basic:8080/credit-check/basic -s -o /dev/null -w "%{http_code}\n"; 
done



echo "                        "
echo "------------------ sleep 20s --------------------------"
sleep 20s



echo "                        "
echo "-----------------kyc-aggregator-mgt  to credit-check/advanced---------------------------"
for((i=1;i<=3;i++)); do 
kubectl exec "$(kubectl get pod -l app=kyc-aggregator-mgt -n consumer -o jsonpath={.items..metadata.name})" -c kyc-aggregator-mgt -n consumer -- curl http://kyc-credit-check-advanced.advanced:8080/credit-check/advanced?triggerMongoError=N -s -o /dev/null -w "%{http_code}\n"
done

echo "                        "
echo "------------------ repeat the script run if you need more test data --------------------------"



