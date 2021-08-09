package com.systrack.admission.adapter.hrAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.CategoryInformation;
import com.systrack.admission.pojo.DepartmentInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class CategoryAdapter extends BaseAdapter {
    ArrayList<CategoryInformation> array_category;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;


    public CategoryAdapter(Context context, ArrayList<CategoryInformation> array_category){
        this.context = context;
        this.array_category = array_category;
    }

    @Override
    public int getCount() {
        return array_category.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertview, ViewGroup viewGroup) {
        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.item_category,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        category_name= (TextView)view.findViewById(R.id.category_name);
        category_alias = (TextView)view.findViewById(R.id.category_alias);

        category_name.setTypeface(typeface_semibold);
        category_alias.setTypeface(typeface_regular);



        category_name.setText(array_category.get(i).getCATEGORYNAME());
        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}
