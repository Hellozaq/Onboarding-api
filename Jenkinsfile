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
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ANANAzZzZz/Onboarding-api.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('SAST Analysis (SonarQube)') {
            environment {
                SONAR_TOKEN = credentials('sonar-token')
            }
            steps {
                bat 'mvn sonar:sonar -Dsonar.projectKey=Onboarding-api -Dsonar.host.url=http://localhost:9000 -Dsonar.login=%SONAR_TOKEN%'
            }
        }
        stage('Dependency Check') {
            steps {
                bat 'mvn org.owasp:dependency-check-maven:check'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/dependency-check-report.*', fingerprint: true
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Flyway Migration') {
            steps {
                bat 'mvn flyway:migrate -Dflyway.url="%SPRING_DATASOURCE_URL%" -Dflyway.user="%SPRING_DATASOURCE_USERNAME%" -Dflyway.password="%SPRING_DATASOURCE_PASSWORD%"'
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
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
