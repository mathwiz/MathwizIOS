package pattern.structural

class EnhancedContainerNameAsset extends AssetDecorator {
    def containerName() {
        "The container of ${asset .getName()} is ${asset .containerName()}"
    }
}
