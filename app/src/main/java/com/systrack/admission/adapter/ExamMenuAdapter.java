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
import com.systrack.admission.fragment.Examination.BroadsheetFragment;
import com.systrack.admission.fragment.Examination.ExamMasterFragment;
import com.systrack.admission.fragment.Examination.ExamTimeTableFragment;
import com.systrack.admission.fragment.Examination.GenerateMarkSheetFragment;
import com.systrack.admission.fragment.Examination.HallArrangementTabLayoutFragement;
import com.systrack.admission.fragment.Examination.ModeratorAffiliationFragment;
import com.systrack.admission.fragment.Examination.PublishExamTimeTableFragment;
import com.systrack.admission.fragment.Examination.PublishMarksheetFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;

public class ExamMenuAdapter extends RecyclerView.Adapter<ExamMenuAdapter.ViewHolder> {
    private String[] sliderpojo_arrayList;

    private Context context;
    String DYNAMICLABEL;
    SharedPreferences sharedpreferences;

    public ExamMenuAdapter(Context context, String[] sliderpojo_arrayList) {
        this.context=context;
        this.sliderpojo_arrayList=sliderpojo_arrayList;
//        DYNAMICLABEL = String.valueOf(sharedpreferences.getString(context.getString(R.string.DYNAMICLABEL),""));
    }

    @Override
    public ExamMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_menu_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExamMenuAdapter.ViewHolder viewHolder, final int i) {


        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
//Log.e("DYNAMICLABELD  ",DYNAMICLABEL+"**");
        viewHolder.menu_title.setText(sliderpojo_arrayList[i]);
        viewHolder.menu_title.setTypeface(typeface_semibold);




        if(sliderpojo_arrayList[i].equals("Exam Master"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_MASTER));
        }else if(sliderpojo_arrayList[i].equals("Exam Timetable"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_TIMETABLE));

        }else if(sliderpojo_arrayList[i].equals("Hall Arrangement"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_HALL));
        }
        else if(sliderpojo_arrayList[i].equals("Publish Exam Timetable"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_PUBLISH));
        } else if(sliderpojo_arrayList[i].equals("Moderator Affiliation"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_MODERATE));

        } else if(sliderpojo_arrayList[i].equals("Generate Marksheet"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_MARKSHEET));

        }
        else if(sliderpojo_arrayList[i].equals("Publish Marksheet"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.EXAM_PUBLISH));
        }
        else if(sliderpojo_arrayList[i].equals("Broadsheet"))
        {
            viewHolder.icon_nav.setText(context.getResources().getString(R.string.BROADCAST));
        }



        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sliderpojo_arrayList[i].equals("Exam Master"))
                {
                    ExamMasterFragment fragement = new ExamMasterFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();



                }else if(sliderpojo_arrayList[i].equals("Exam Timetable"))
                {
                    ExamTimeTableFragment fragement = new ExamTimeTableFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }else if(sliderpojo_arrayList[i].equals("Hall Arrangement"))
                {
                    HallArrangementTabLayoutFragement fragement = new HallArrangementTabLayoutFragement();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }
                else if(sliderpojo_arrayList[i].equals("Publish Exam Timetable"))
                {
                    PublishExamTimeTableFragment fragement = new PublishExamTimeTableFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                } else if(sliderpojo_arrayList[i].equals("Moderator Affiliation"))
                {
                    ModeratorAffiliationFragment fragement = new ModeratorAffiliationFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }else if(sliderpojo_arrayList[i].equals("Generate Marksheet"))
                {
                    GenerateMarkSheetFragment fragement = new GenerateMarkSheetFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }else if(sliderpojo_arrayList[i].equals("Publish Marksheet"))
                {
                    PublishMarksheetFragment fragement = new PublishMarksheetFragment();
                    FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragement);
                    transaction.commit();

                }else if(sliderpojo_arrayList[i].equals("Broadsheet"))
                {
                    BroadsheetFragment fragement = new BroadsheetFragment();
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

