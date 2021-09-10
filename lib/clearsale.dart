import 'dart:async';

import 'package:flutter/services.dart';

class Clearsale {
  static const MethodChannel _channel = const MethodChannel('clearsale');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('csdp');
    return version;
  }
}
