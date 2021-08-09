package com.systrack.admission.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.systrack.admission.R;
import com.systrack.admission.fragment.LeaveManagement.EmpLeaveReportingFragment;
import com.systrack.admission.fragment.LeaveManagement.LeaveApplicationFragment;
import com.systrack.admission.fragment.LeaveManagement.LeaveAssignFragment;
import com.systrack.admission.fragment.LeaveManagement.LeaveDurationFragment;
import com.systrack.admission.fragment.LeaveManagement.LeaveReportingFragment;
import com.systrack.admission.fragment.LeaveManagement.LeaveTypeFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;

public class LeaveMgtMenuAdapter extends RecyclerView.Adapter<LeaveMgtMenuAdapter.ViewHolder> {
    private String[] sliderpojo_arrayList;

    private Context context;
    String DYNAMICLABEL;
    SharedPreferences sharedpreferences;

    public LeaveMgtMenuAdapter(Context context, String[] sliderpojo_arrayList) {
        this.context=context;
        this.sliderpojo_arrayList=sliderpojo_arrayList;
//        DYNAMICLABEL = String.valueOf(sharedpreferences.getString(context.getString(R.string.DYNAMICLABEL),""));
    }

    @Override
    public LeaveMgtMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_menu_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LeaveMgtMenuAdapter.ViewHolder viewHolder, final int i) {


        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
//Log.e("DYNAMICLABELD  ",DYNAMICLABEL+"**");
        viewHolder.menu_title.setText(sliderpojo_arrayList[i]);
        viewHolder.menu_title.setTypeface(typeface_semibold);




        if(sliderpojo_arrayList[i].equals("Leave Type"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.LEAVE_TYPE));
        }else if(sliderpojo_arrayList[i].equals("Leave Duration"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.LEAVE_DURATION));

        }else if(sliderpojo_arrayList[i].equals("Leave Reporting"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.LEAVE_REPORTING));

        }else if(sliderpojo_arrayList[i].equals("Leave Assign"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.LEAVE_ASSIGN));

        }else if(sliderpojo_arrayList[i].equals("Leave Application"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.LEAVE_APPLICATION));
        }else if(sliderpojo_arrayList[i].equals("Employee Leave Reporting"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.LEAVE_APPLICATION));

        }

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sliderpojo_arrayList[i].equals("Leave Type"))
                {
                    LeaveTypeFragment fragement = new LeaveTypeFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();



                }else if(sliderpojo_arrayList[i].equals("Leave Duration"))
                {
                    LeaveDurationFragment fragement = new LeaveDurationFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }else if(sliderpojo_arrayList[i].equals("Leave Reporting"))
                {
                    LeaveReportingFragment fragement = new LeaveReportingFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                } else if(sliderpojo_arrayList[i].equals("Leave Assign"))
                {
                    LeaveAssignFragment fragement = new LeaveAssignFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                } else if(sliderpojo_arrayList[i].equals("Leave Application"))
                {
                    LeaveApplicationFragment fragement = new LeaveApplicationFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                } else if(sliderpojo_arrayList[i].equals("Employee Leave Reporting"))
                {
                    EmpLeaveReportingFragment fragement = new EmpLeaveReportingFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sliderpojo_arrayList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView menu_title;
        FontAwesomeTextview icon_nav;
        LinearLayout li;
        CardView cardView;
        public ViewHolder(View view) {
            super(view);


            menu_title = (TextView)view.findViewById(R.id.menu_title);
            icon_nav = (FontAwesomeTextview) view.findViewById(R.id.menu_icon);
            li = (LinearLayout)view.findViewById(R.id.linear);
            cardView=view.findViewById(R.id.card_view);
        }
    }
}
//    LayoutInflater inflater;
//    ArrayList<ChildMenuListPOJO> sliderpojo_arrayList;
//    Context context;
//    FontAwesomeTextview icon_nav;
//
//
//    public CourseAdapter(Context context, ArrayList<ChildMenuListPOJO> sliderpojo_arrayList)
//    {
//        this.context=context;
//        this.sliderpojo_arrayList=sliderpojo_arrayList;
//
//    }
//
//    @Override
//    public int getCount() {
//        return sliderpojo_arrayList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return i;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View convertView, ViewGroup viewGroup) {
//        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.list_academic_items,viewGroup,false);
//
//        Typeface typeface_bold = Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-SemiBold.ttf");
//        Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf" );
//
//        icon_nav=(FontAwesomeTextview) view.findViewById(R.id.menu_icon);
//
//
//        icon_nav.setText(sliderpojo_arrayList.get(i).getItemicon());
//        icon_nav.setTypeface(font_icon);
//        icon_nav.setText(sliderpojo_arrayList.get(i).getItemicon());
//        icon_nav.setTypeface(font_icon);
//        if(sliderpojo_arrayList.get(i).getItemtitle().equals("Course Management"))
//        {
//            icon_nav.setText(context.getResources().getString(R.string.academic_icon));
////            arrow.setVisibility(View.VISIBLE);
//        }else if(sliderpojo_arrayList.get(i).getItemtitle().equals("Time Table"))
//        {
//            icon_nav.setText(context.getResources().getString(R.string.hr_icon));
////            arrow.setVisibility(View.VISIBLE);
//
//        }else if(sliderpojo_arrayList.get(i).getItemtitle().equals("Placement"))
//        {
//            icon_nav.setText(context.getResources().getString(R.string.student_icon));
////            arrow.setVisibility(View.VISIBLE);
//
//        }
//        else if(sliderpojo_arrayList.get(i).getItemtitle().equals("Online Test"))
//        {
//            icon_nav.setText(context.getResources().getString(R.string.document_icon));
////            arrow.setVisibility(View.VISIBLE);
//
//        }
//        else if(sliderpojo_arrayList.get(i).getItemtitle().equals("Student Attendance"))
//        {
//            icon_nav.setText(context.getResources().getString(R.string.communication_icon));
////            arrow.setVisibility(View.VISIBLE);
//
//        }
//        else if(sliderpojo_arrayList.get(i).getItemtitle().equals("Academics"))
//        {
//            icon_nav.setText(context.getResources().getString(R.string.administration_icon));
////            arrow.setVisibility(View.VISIBLE);
//
//        }
//
//        return view;
//    }

