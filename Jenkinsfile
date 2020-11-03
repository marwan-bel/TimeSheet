pipeline {


        agent any
       
        tools{
                maven 'Maven'
        }
 
        stages{
        
            stage('Clean'){
                steps {
                	        script {
                            try {
				                 echo "Clean project"
				                 bat "mvn clean"
				                }catch(err)
				                {
				                mail bcc: '', body: "${err}", cc: '', from: '', replyTo: '', subject: 'Jenkins Clean Failure', to: 'houssem.entr@gmail.com'
				                }
				                
				                }

                }
            }

             stage('Deploy'){
                steps {
                	        script {
                            try {				               
				                 echo "Deploy project"
				                 bat "mvn deploy"
				                 bat "mvn sonar:sonar"
				                }catch(errr)
				                {
				                mail bcc: '', cc: '', from: '', replyTo: '',
				                subject: "TESTS Job '${env.JOB_NAME}'- (${env.BUILD_NUMBER}) || DEPLOY ERROR:  ${errr}",
                                body: readFile("target/surefire-reports/tn.esprit.spring.TimesheetApplicationTests.txt"),
                                mimeType:'text/html',
                                to: 'houssem.entr@gmail.com'
				                def myvar=${errr}
				                echo ${myvar}
				                }
				                
				                }				             

                } 
            }
         
        }


post {




    always {
				                mail bcc: '', cc: '', from: '', replyTo: '',
				                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME} - (${env.BUILD_NUMBER})",
                                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                                to: 'houssem.entr@gmail.com'
            }
}


}