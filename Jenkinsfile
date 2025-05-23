pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK'
    }
    environment {
        POSTGRES_CREDENTIALS = credentials('postgres-credentials')
        SPRING_DATASOURCE_URL = 'jdbc:postgresql://ep-muddy-mountain-a49jffvc-pooler.us-east-1.aws.neon.tech:5432/onboarding-api?sslmode=require'
        SPRING_DATASOURCE_USERNAME = "${POSTGRES_CREDENTIALS_USR}"
        SPRING_DATASOURCE_PASSWORD = "${POSTGRES_CREDENTIALS_PSW}"
        NEXUS_CREDENTIALS = credentials('nexus-credentials')
        NEXUS_USERNAME = "${NEXUS_CREDENTIALS_USR}"
        NEXUS_PASSWORD = "${NEXUS_CREDENTIALS_PSW}"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ANANAzZzZz/Onboarding-api.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/site/jacoco/jacoco.xml', fingerprint: true
                }
            }
        }
        stage('SAST Analysis (SonarQube)') {
            environment {
                SONAR_TOKEN = credentials('sonar-token')
            }
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=Onboarding-api -Dsonar.host.url=http://158.160.38.125:9000 -Dsonar.login=$SONAR_TOKEN'
            }
        }
//         stage('Dependency Check') {
//             steps {
//                 withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
//                     sh 'mvn org.owasp:dependency-check-maven:check -DnvdApiKey=$NVD_API_KEY'
//                 }
//             }
//         }
        stage('Flyway Migration') {
            steps {
                sh 'mvn flyway:migrate -Dflyway.url="$SPRING_DATASOURCE_URL" -Dflyway.user="$SPRING_DATASOURCE_USERNAME" -Dflyway.password="$SPRING_DATASOURCE_PASSWORD"'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
        stage('Deploy to Nexus') {
            steps {
                script {
                    def pom = readMavenPom file: 'pom.xml'
                    def version = pom.version
                    if (version.contains('-SNAPSHOT')) {
                        echo "Deploying SNAPSHOT version ${version} to maven-snapshots"
                    } else {
                        echo "Deploying RELEASE version ${version} to maven-releases"
                    }
                    sh 'mvn deploy -DskipTests'
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build and deployment completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}