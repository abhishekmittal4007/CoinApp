package com.digi.pay.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.custom.textviews.SemiBoldTextView;
import com.digi.pay.ui.CreateAccountActivity;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static android.app.Activity.RESULT_OK;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_adhar_card)
public class FragmentAadharCard extends Fragment {

    @ViewById(R.id.upload_aadhar)
    RelativeLayout upload_aadhar;

    @ViewById(R.id.et_password)
    SemiBoldTextView et_password;

    @ViewById(R.id.img_aadhar_photo)
    ImageView img_aadhar_photo;

    @ViewById(R.id.img_cancel)
    ImageView img_cancel;

    private static final int SET_STORAGE = 2;
    public static final int SET_WRITE = 1;
    private static final int SET_CAMERA = 3;
    private static final int SELECT_PICTURE = 100;

    @AfterViews
    public void init() {
        ((CreateAccountActivity) requireActivity()).step_indicator.setCurrentStep(1);

       /* et_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "get", Toast.LENGTH_SHORT).show();
                OpenUploadSelection();

            }
        });*/

    }

    @Click(R.id.btn_back)
    public void setBack() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    @Click(R.id.btn_cntn)
    public void setSendOtp() {
        Utility.showFragment(getActivity(), new Fragment_Verification_()
                , R.id.main_frame, null, Fragment_Verification.class.getSimpleName());
    }

    @Click({R.id.et_password, R.id.img_aadhar_photo})
    public void OpenUploadSelection()
    {
        // cxode for upload image
        int hasStorageaPermission = ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
        int hasCameraPermission = ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA);
        int hasWritePermisson = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (Build.VERSION.SDK_INT < 23) {
            //do nothing

            selectMediaOptions();

        } else if ((hasStorageaPermission != PackageManager.PERMISSION_GRANTED) || (hasCameraPermission != PackageManager.PERMISSION_GRANTED) || (hasWritePermisson != PackageManager.PERMISSION_GRANTED)) {
            requeststoragePermission();
            requestwritePermission();
            requestCameraPermission();
            selectMediaOptions();
        } else {

            selectMediaOptions();
        }

    }


    private void requeststoragePermission() {
        int hasCameraPermission = ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE);

        if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, SET_STORAGE);
        }
    }

    private void requestwritePermission() {
        int haswritePermission = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (haswritePermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, SET_WRITE);
        }
    }


    /**
     * code for select image
     */
    private void requestCameraPermission() {
        int hasCameraPermission = ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA);

        if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.CAMERA}, SET_CAMERA);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case SET_CAMERA:

                // Check if the only required permission has been granted
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Camera permission has been granted, preview can be displayed
                    Log.i("Permission", "Location permission has now been granted. Showing result.");


                } else {
                    Log.i("Permission", "Location permission was NOT granted.");
                    //     Toast.makeText(MainActivity.this, "Location Permission is not Granted", Toast.LENGTH_SHORT).show();
                }

                break;
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                android.Manifest.permission.CAMERA)) {
            new android.app.AlertDialog.Builder(getActivity())
                    .setTitle("Required Attention")
                    .setMessage("Phone state permission is require to Access Your Storage")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.CAMERA},
                                    SET_CAMERA);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

    }


    public void selectMediaOptions() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Choose an option");

// add a list
        String[] animals = {"Take Photo", "Choose from Library"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, 3);
                        break;
                    case 1:
                        openImageChooser();
                        break;

                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    /*/ Choose an image from Gallery /*/
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);//
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PICTURE) {
            // Get the url from data

            if (resultCode == RESULT_OK) {

                Uri selectedImageUri = data.getData();

                //final_uri = selectedImageUri;

                if (null != selectedImageUri) {
                    // Get the path from the Uri

                   /* String path;

                    if (Build.VERSION.SDK_INT >= 19) {

                        path = RealPathUtil.getRealPathFromURI_API19(getContext(), selectedImageUri);

                    } else {
                        path = RealPathUtil.getRealPathFromURI_API11to18(getContext(), selectedImageUri);
                    }


                    Log.e("real path gallery ", path);

                    //  Log.i(TAG, "Image Path : " + path);
                    // Set the image in ImageView

                    selected_file = new File(path);
                    // fileArrayList.add(afile);

                    final_file = new File(path);


                    CropingIMG();


                    flag = 1;*/

                   et_password.setVisibility(View.GONE);
                   img_aadhar_photo.setVisibility(View.VISIBLE);
                   img_cancel.setVisibility(View.VISIBLE);
                   img_aadhar_photo.setImageURI(selectedImageUri);

                }

            }


        }


        if (requestCode == 3) {

            if (resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");


                Log.e("bitmap", String.valueOf(photo));

               // profilePhoto.setImageBitmap(photo);
                et_password.setVisibility(View.GONE);
                img_aadhar_photo.setVisibility(View.VISIBLE);
                img_cancel.setVisibility(View.VISIBLE);
                img_aadhar_photo.setImageBitmap(photo);

               /* try {


                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 50, baos);
                    Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(baos.toByteArray()));

                    // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                    Uri tempUri = getImageUri(getActivity(), decoded);

                    final_uri = getImageUri(getActivity(), decoded);

                    // CALL THIS METHOD TO GET THE ACTUAL PATH
                    File finalFile = new File(getRealPathFromURI(tempUri));

                    Log.e("finalfile", String.valueOf(finalFile));

                    fileup = new File(getRealPathFromURI(tempUri));

                    final_file = new File(getRealPathFromURI(tempUri));

                    CropingIMG();

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";

                    flag = 1;

                    // f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    // may be this lien changes the name of selected imaeg from gallery
                    //   /// remove it from above and add profile ....if it not work plz replcae it
                    try {
                        outFile = new FileOutputStream(file);
                        photo.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
*/
            }


        }


    } // end on activity result

    @Click(R.id.img_cancel)
    public void RemoveImage()
    {
        img_aadhar_photo.setVisibility(View.GONE);
        et_password.setVisibility(View.VISIBLE);
        img_cancel.setVisibility(View.GONE);
    }


}
