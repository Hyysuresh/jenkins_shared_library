def call(Map config = [:]) {
    def imageName = config.imageName ?: error('image name is requried')
    def imageTag = config.imageTag ?: 'latest'
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def context = config.context ?: '.'

    echo "building docker image: ${imageName}:${imageTag} using ${dockerfile}"

    sh """

    docker build -t ${imageName}:${imageTag} -f ${dockerfile} ${context}
    
    """
}