package com.credit.check.util;

public class MassiveTestString 
{
	
	
	static String testString = "$  kubectl get pods --all-namespaces\r\n" + 
			"NAMESPACE      NAME                                         READY   STATUS             RESTARTS   AGE\r\n" + 
			"advanced       kyc-credit-check-advanced-799795b457-tfxbv   2/2     Running            1          98m\r\n" + 
			"basic          kyc-credit-check-basic-d87477769-b88d7       2/2     Running            0          98m\r\n" + 
			"consumer       kyc-aggregator-mgt-7f6ddc8bbd-qmhxg          2/2     Running            0          98m\r\n" + 
			"istio-system   grafana-69ccf87b97-7llsh                     0/1     Running            1          88m\r\n" + 
			"istio-system   istio-egressgateway-799df76979-lfp2t         1/1     Running            0          107m\r\n" + 
			"istio-system   istio-ingressgateway-5cfc5bff6d-hszjj        1/1     Running            0          107m\r\n" + 
			"istio-system   istiod-5c6d68885d-wj6hz                      0/1     Running            0          108m\r\n" + 
			"istio-system   jaeger-648f4f4ddb-lf28s                      0/1     CrashLoopBackOff   11         94m\r\n" + 
			"istio-system   prometheus-f675ff955-d48w8                   1/2     Running            8          94m\r\n" + 
			"kafka-ca1      kafka-0                                      2/2     Running            1          105m\r\n" + 
			"kafka-ca1      kafka-1                                      2/2     Running            1          100m\r\n" + 
			"kafka-ca1      kafka-2                                      2/2     Running            1          99m\r\n" + 
			"kafka-ca1      zookeeper-5c979cbf89-7fppt                   2/2     Running            0          105m\r\n" + 
			"kube-system    coredns-74ff55c5b-bn5w7                      1/1     Running            0          109m\r\n" + 
			"kube-system    etcd-minikube                                1/1     Running            3          109m\r\n" + 
			"kube-system    kube-apiserver-minikube                      0/1     Running            4          109m\r\n" + 
			"kube-system    kube-controller-manager-minikube             1/1     Running            1          110m\r\n" + 
			"kube-system    kube-proxy-zc77s                             1/1     Running            0          109m\r\n" + 
			"kube-system    kube-scheduler-minikube                      1/1     Running            0          109m\r\n" + 
			"kube-system    storage-provisioner                          1/1     Running            13         109m\r\n" + 
			"mongo          mongo-0                                      2/2     Running            0          105m\r\n" + 
			""; 
	
	public static String getMassiveTestString()
	{
		String massiveTestString = "";
		/*
		for(int i=0; i<10; i++ )
		{
			massiveTestString = massiveTestString + testString;
			
		}
		*/
		return massiveTestString;
	}

}
