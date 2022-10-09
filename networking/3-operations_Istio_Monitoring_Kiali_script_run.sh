echo "                        "
echo "------------------ Start Mesh Monitoring deploys --------------------------"

echo "                        "
echo "------------------kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/prometheus.yaml--------------------------"
kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/prometheus.yaml

echo "                        "
echo "------------------kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.14/samples/addons/jaeger.yaml--------------------------"
kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.14/samples/addons/jaeger.yaml

echo "                        "
echo "------------------skipping .. istioctl dashboard jaeger      run only if UI need. Causes memory load--------------------------"
#istioctl dashboard jaeger

echo "                        "
echo "------------------kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/kiali.yaml--------------------------"
kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/kiali.yaml


echo "                        "
echo "------------------ sleeping 180s until Kiali PODs get enabled --------------------------"
sleep 180s


echo "                        "
echo "------------------istioctl dashboard kiali--------------------------"
istioctl dashboard kiali
