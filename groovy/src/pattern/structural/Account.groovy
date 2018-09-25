package pattern.structural

class Account extends CompositeAsset {
    String description() {
        "Account: " + super.description()
    }
}
