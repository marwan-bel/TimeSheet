pipeline {


        agent any
       
        tools{
                maven 'Maven'
        }
        environment {
		imagename = "marwanbeltaief/cd"
   		registryCredential = 'dockerhub_id'
   		dockerImage = ''
            	PAGERDUTY_SERVERS_INT_KEY = credentials('PAGERDUTY_SERVERS_INT_KEY')
		
    }

 
        stages{
        
            stage('Clean'){
                steps {
                	        script {
                            
				                 echo "Clean project"
				                 bat "mvn clean"
				                
				                
				                }

                }
            }

             stage('Deploy'){
                steps {
                	        script {
                            				               
				                 echo "Deploy project"
				                 bat "mvn deploy"
				                 bat "mvn sonar:sonar"
				                }
				                
				                
				                }				             

                }
             stage('Building image') {
      	        steps{
       			        script {
       					          dockerImage = docker.build imagename
      						  }
      					}
   				 }
   				 
     	     stage('Deploy Image') {
 		steps{
       				script {
        						  docker.withRegistry( '', registryCredential ) {
          						  dockerImage.push("$BUILD_NUMBER")
         					      	  dockerImage.push('latest')

        					      }
       					 		}
    					  }
   				 }

            }

post {
    failure {
            sh  """ curl -X POST -H "content-type: application/json" \
                -d '{"routing_key":"${env.PAGERDUTY_SERVERS_INT_KEY}","event_action":"trigger","payload":{"summary":"${env.JOB_NAME} job failed ${env.BUILD_URL}","source":"Jenkins","severity":"critical","component":"exploratory-stats","group":"prod-datapipe","class":"deploy"}}' \
                https://events.pagerduty.com/v2/enqueue"""
        }





}
}

       





