pipeline {


        agent any
       
        tools{
                maven 'Maven'
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
            }
         
        



}

