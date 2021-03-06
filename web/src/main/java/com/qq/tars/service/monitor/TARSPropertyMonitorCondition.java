/*
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.qq.tars.service.monitor;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TARSPropertyMonitorCondition {

    private String thedate, predate, theshowtime, preshowtime;

    private String masterName, masterIp, propertyName, policy;

    private String groupBy;

    public TARSPropertyMonitorCondition(HttpServletRequest request) {
        thedate = StringUtils.trimToNull(request.getParameter("thedate"));
        predate = StringUtils.trimToNull(request.getParameter("predate"));
        theshowtime = StringUtils.trimToNull(request.getParameter("startshowtime"));
        preshowtime = StringUtils.trimToNull(request.getParameter("endshowtime"));

        masterName = StringUtils.trimToNull(request.getParameter("master_name"));
        masterIp = StringUtils.trimToNull(request.getParameter("master_ip"));
        propertyName = StringUtils.trimToNull(request.getParameter("property_name"));
        policy = StringUtils.trimToNull(request.getParameter("policy"));

        groupBy = StringUtils.trimToNull(request.getParameter("group_by"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (null == thedate) {
            thedate = LocalDate.now().format(formatter);
        }
        if (null == predate) {
            predate = LocalDate.parse(thedate, formatter).plusDays(-1).format(formatter);
        }
        if (null == theshowtime) {
            theshowtime = "0000";
        }
        if (null == preshowtime) {
            preshowtime = "2360";
        }
    }

    public String getThedate() {
        return thedate;
    }

    public void setThedate(String thedate) {
        this.thedate = thedate;
    }

    public String getPredate() {
        return predate;
    }

    public void setPredate(String predate) {
        this.predate = predate;
    }

    public String getTheshowtime() {
        return theshowtime;
    }

    public void setTheshowtime(String theshowtime) {
        this.theshowtime = theshowtime;
    }

    public String getPreshowtime() {
        return preshowtime;
    }

    public void setPreshowtime(String preshowtime) {
        this.preshowtime = preshowtime;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterIp() {
        return masterIp;
    }

    public void setMasterIp(String masterIp) {
        this.masterIp = masterIp;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
}
