package com.example.ryu_hw.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

/**
 * Created by Ryu_hw on 2016-10-27.
 */

public class aroundMap extends Activity implements MapView.OpenAPIKeyAuthenticationResultListener, MapView.MapViewEventListener, MapView.CurrentLocationEventListener, MapView.POIItemEventListener {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroundmap);
        init();


    }

    protected void init() {
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("c5276540deb89d6633aa2fbf5388e50e");
        mapView.setOpenAPIKeyAuthenticationResultListener(this);
        mapView.setMapViewEventListener(this);
        mapView.setCurrentLocationEventListener(this);
        mapView.setPOIItemEventListener(this);
        mapView.setMapType(MapView.MapType.Standard);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        //  mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.551558, 126.940592),true);
        //   mapView.setZoomLevel(4,true);
        mapViewContainer.addView(mapView);

        Toast.makeText(this, "초기화화", Toast.LENGTH_LONG).show();

        //  MapPOIItem markers;
        // markers=new MapPOIItem();

        // markers.setItemName("test");
        //markers.setTag(0);
        //  markers.setMapPoint(MapPoint.mapPointWithGeoCoord(134.4759,126.17889));
        //   markers.setMarkerType(MapPOIItem.MarkerType.BluePin);
        //    mapView.addPOIItem(markers);

    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.551558, 126.940592), true);
        mapView.setZoomLevel(2, true);

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {
        MapPOIItem a = new MapPOIItem();
        a.setItemName("서강대학교 정문");
        a.setMapPoint(MapPoint.mapPointWithGeoCoord(37.551582, 126.937661));
        a.setSelectedMarkerType(MapPOIItem.MarkerType.BluePin);
        a.setShowCalloutBalloonOnTouch(true);
        a.setShowDisclosureButtonOnCalloutBalloon(true);
        a.setTag(1);
        mapView.addPOIItem(a);
        mapView.fitMapViewAreaToShowAllPOIItems();

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onDaumMapOpenAPIKeyAuthenticationResult(MapView mapView, int i, String s) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
        //여기에 주소 정보 받기로 넘기기
        AlertDialog.Builder alert = new AlertDialog.Builder(aroundMap.this);
        alert.setPositiveButton("닫기!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alert.setMessage(mapPOIItem.getItemName().toString() + "\n02-705-8114");
        alert.show();
    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
}