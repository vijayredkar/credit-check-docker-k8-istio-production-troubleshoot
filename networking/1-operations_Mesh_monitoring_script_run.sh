cd /c/Vijay/Java/projects/kyc-k8-docker-istio/networking

echo "                        "
echo "--------------- 1A-operations_Istio_script_run.sh --------"
./1A-operations_Istio_script_run.sh


echo "                        "
echo "--------------- 1B-operations_Istio_pods_create_script_run.sh --------"
./1B-operations_Istio_pods_create_script_run.sh


	#--Prometheus-Jaeger
echo "                        "
echo "--------------- 5A-operations_Istio_Prometheus_Jaeger_script_run.sh --------"
./5A-operations_Istio_Prometheus_Jaeger_script_run.sh



