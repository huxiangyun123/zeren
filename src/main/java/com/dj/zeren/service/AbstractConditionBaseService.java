package com.dj.zeren.service;


import com.dj.zeren.model.ServiceContext;


public abstract class AbstractConditionBaseService implements BaseService {


    @Override
    public boolean condition(ServiceContext context) {
       /* if (context.getConditionConfig().getRunAll()) {
            return true;
        } else {
            InvoicingBiz invoicingBiz = this.getClass().getAnnotation(InvoicingBiz.class);
            if (invoicingBiz != null) {
                List<String> filterList = context.getConditionConfig().getConditionList().stream().
                        filter(f -> f.toLowerCase().equals(invoicingBiz.value().toLowerCase())).collect(Collectors.toList());
                if (filterList != null && filterList.size() > 0) {
                    return true;
                }
            }

        }
        return false;*/

       if(context.getBreakFlag()==null||context.getBreakFlag().booleanValue()==true)
       {
           return  true;
       }

       return false;
    }
}
