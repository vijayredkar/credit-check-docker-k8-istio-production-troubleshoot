echo "                        "
echo "------------------ Start Mesh Monitoring Grafana--------------------------"



echo "-------------    run cmds as an Admin  ---------   "

echo "------------------ net stop winnat   --------------------------"
net stop winnat

echo "------------------ net start winnat   --------------------------"
net start winnat


echo "                        "
echo "------------------ kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/grafana.yaml   --------------------------"
kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.13/samples/addons/grafana.yaml


echo "                        "
echo "------------------ sleeping 180s until Grafana PODs get enabled --------------------------"
sleep 180s


echo "                        "
echo "------------------  istioctl dashboard grafana --------------------------"
istioctl dashboard grafana