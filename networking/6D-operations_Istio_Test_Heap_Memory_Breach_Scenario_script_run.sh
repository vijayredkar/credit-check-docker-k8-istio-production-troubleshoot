echo "                        "
echo "------------------ Starting Mesh Heap Memory Breach Error Testing/Data loading scripts --------------------------"


for((i=1;i <10 ;i++)); do  
kubectl exec "$(kubectl get pod -l app=kyc-aggregator-mgt -n consumer -o jsonpath={.items..metadata.name})" -c kyc-aggregator-mgt -n consumer -- curl http://kyc-credit-check-advanced.advanced:8080/credit-check/advanced?triggerHeapMemoryError=Y -s -o /dev/null -w "%{http_code}\n"
sleep 10s
done


echo "                        "
echo "------------------ repeat the script run if you need more test data --------------------------"










