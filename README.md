# lambda-as-rest-api
Deploy AWS lambda function as a rest api in java

### The project source includes function code and supporting resources:

`src/main` - A Java function.

`template.yml` - An AWS CloudFormation template that creates an application.

`pom.xml` - A Maven build file.

`create-bucket.sh` - Shell script to create an AWS bucket

`deploy.sh` - Shell script to generate the build package and deploy it to AWS cloudformation

### Use the following instructions to deploy the sample application.

#### Requirements
  Java 8 runtime environment (SE JRE)
  
  Maven 3
  
  The Bash shell. For Linux and macOS, this is included by default. In Windows 10, you can install the Windows Subsystem for Linux to get a Windows-integrated version of Ubuntu and Bash.
  
  The AWS CLI v1.17 or newer.

#### Steps to execute
1) Clone this repository
2) Execute the create-bucket.sh file (./create-bucket.sh)
3) Execute the deploy.sh file (./deploy.sh)
4) Follow this tutorial to  visualize the results: 
