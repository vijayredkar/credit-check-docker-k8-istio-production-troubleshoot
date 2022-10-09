cd /c/Vijay/Java/projects/kyc-k8-docker-istio/networking

echo "---------------operations_istio_KYC.sh--------"
./operations_istio_KYC.sh




echo "                        "
echo "------------------Gateway IP - minikube ip--------------------------"
minikube ip



#echo "                        "
#echo "---------------Istio Port - kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].nodePort}'--------"
#kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].nodePort}'


echo "                        "
echo "------------------Istio Port - kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}'--------------------------"
kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}'



echo "                        "
echo "------------------Update kyc-aggregator-mgt application with  Gateway IP--------------------------"

echo "                        "
echo "------------------Update kyc-aggregator-mgt application with  Istio Port--------------------------"



echo "                        "
echo "############################ Please complete your config update and press ENTER to continue ########################"
read -p "Press Enter to continue" </dev/tty



#./5-operations_Istio_Mongo_script_run.sh








