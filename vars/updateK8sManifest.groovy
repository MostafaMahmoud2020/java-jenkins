def call() {
    withCredentials([sshUserPrivateKey(credentialsId: 'github-ssh-key', keyFileVariable: 'SSH_KEY')]) {
        sh """
            rm -rf argocd-test
            GIT_SSH_COMMAND='ssh -i $SSH_KEY -o StrictHostKeyChecking=no' git clone git@github.com:MostafaMahmoud2020/argocd-test.git
            cd argocd-test
            sed -i 's|image: .*|image: mostafamahmoud0/test-java-app:v${env.BUILD_NUMBER}|' deployment.yaml
            git config user.email "jenkins@example.com"
            git config user.name "Jenkins"
            git commit -am "Update image to mostafamahmoud0/test-java-app:v${env.BUILD_NUMBER}"
            git push origin main
        """
    }
}
