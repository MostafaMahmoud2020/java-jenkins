def call() {
    archiveArtifacts artifacts: '**/*.jar', followSymlinks: false
}

