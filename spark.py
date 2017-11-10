#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

from pyspark import SparkContext
from pyspark.sql import SQLContext
from pyspark.sql import HiveContext
from pyspark.mllib.linalg import Vectors
from pyspark.mllib.linalg import  VectorUDT
import sys


if __name__ == "__main__":
	sc = SparkContext(appName="Simple App")
	print("*******************"+sys.version)
	sqlContext = HiveContext(sc)
	df = sqlContext.createDataFrame([(1,2),(2,3)])
	df.show()
	#myUDF = udf(toSparseVector, VectorUDT())
	#features = df.withColumn(newColName, myUDF(df["samples"]))
	
	# sqlContext.tables().show()