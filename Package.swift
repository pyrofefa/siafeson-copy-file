// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "SiafesonCopyFile",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "SiafesonCopyFile",
            targets: ["CopyFileSiafesonPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "CopyFileSiafesonPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CopyFileSiafesonPlugin"),
        .testTarget(
            name: "CopyFileSiafesonPluginTests",
            dependencies: ["CopyFileSiafesonPlugin"],
            path: "ios/Tests/CopyFileSiafesonPluginTests")
    ]
)