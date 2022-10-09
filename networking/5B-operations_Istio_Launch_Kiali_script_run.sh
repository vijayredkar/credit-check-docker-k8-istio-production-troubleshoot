echo "                        "
echo "------------------ Start Mesh Monitoring Kiali --------------------------"


echo "                        "
echo "------------------kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/kiali.yaml--------------------------"
kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/kiali.yaml



echo "                        "
echo "------------------ sleeping 180s until Kiali PODs get enabled --------------------------"
sleep 180s


echo "                        "
echo "------------------ istioctl dashboard kiali --------------------------"
istioctl dashboard kiali




