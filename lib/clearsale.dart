import 'dart:async';

import 'package:flutter/services.dart';

class Clearsale {
  static const MethodChannel _channel = const MethodChannel('clearsale');

  static Future<String?> collectDeviceInformation() async {
    final String? response = await _channel.invokeMethod('device_info');
    return response;
  }

  static Future<String?> stopService() async {
    final String? response = await _channel.invokeMethod('stop');
    return response;
  }
}
