#import "ClearsalePlugin.h"
#if __has_include(<clearsale/clearsale-Swift.h>)
#import <clearsale/clearsale-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "clearsale-Swift.h"
#endif

@implementation ClearsalePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftClearsalePlugin registerWithRegistrar:registrar];
}
@end
