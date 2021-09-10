package com.virtuspay.clearsale;

import androidx.annotation.NonNull;
import android.content.Context;
import android.app.Activity;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import sale.clear.behavior.android.Behavior;

public class ClearsalePlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  private MethodChannel channel;
  private Activity activity;
  private Behavior mBehavior;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "clearsale");
    channel.setMethodCallHandler(this);
  }
  
  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("device_info")) {
      try {
        mBehavior = Behavior.getInstance(this.activity, "91undxujdtt12ly9rkpf");
        mBehavior.start();
        String sessionId = mBehavior.generateSessionID();
        mBehavior.collectDeviceInformation(sessionId);
        result.success("ok");
      } catch (Exception e) {
        result.error("ERROR", e.toString(), null);
      }
    } else if (call.method.equals("stop")) {
      try {
        mBehavior.stop();
        result.success("ok");
      } catch (Exception e) {
        result.error("ERROR", e.toString(), null);
      }
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
    this.activity = activityPluginBinding.getActivity();
  }

  @Override
  public void onDetachedFromActivity() {}

  @Override
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {}

  @Override
  public void onDetachedFromActivityForConfigChanges() {}
}
