
from pyspark.context import SparkContext
import numpy as np

def f(a):
	np.array(1,10)
	return a+1


if __name__ == "__main__":
	
	sc = SparkContext(appName="test")
	sc.parallelize(range(1,10)).map(lambda x:f(x)).sum()
	sc.stop()


