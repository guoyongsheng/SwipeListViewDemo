package xmen.doshr.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xmen.doshr.com.swipelistviewdemo.R;

/**
 * Created by wesley on 2016/2/26.
 */
public class TextAdapter extends BaseAdapter
{

    private List<String> list;
    private LayoutInflater inflater;

    public TextAdapter(List<String> list, Context context)
    {
        this.list = list;
        if (context != null)
        {
            inflater = LayoutInflater.from(context);
        }
    }

    @Override
    public int getCount()
    {
        if (list != null)
        {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position)
    {
        if (list != null && list.size() > position)
        {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (list == null)
        {
            return null;
        }

        ViewHoler viewHoler;
        if (convertView == null)
        {
            viewHoler = new ViewHoler();
            convertView = inflater.inflate(R.layout.adapter_text, null);
            viewHoler.textView = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHoler);
        } else
        {
            viewHoler = (ViewHoler) convertView.getTag();
        }

        String value = list.get(position);
        viewHoler.textView.setText(value);
        return convertView;
    }


    //内部类
    private static final class ViewHoler
    {
        private TextView textView;
    }
}
