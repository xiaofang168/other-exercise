import requests
import json
from selenium import webdriver


#login_cookies = session.post(url = login_url, json=json.dumps(data)).cookies.get_dict()
#print(login_cookies)

json_obj ={
    "reportId": 172024,
    "sliceId": 4142422,
    "monitorName": "3080日环比(26以后)",
    "filters": [
        {
            "conditionIndex": None,
            "columnCode": "datae_column_c902aa2b3b",
            "dataSourceCode": "table_1653635662711",
            "authType": 0,
            "isParam": False,
            "compareType": "eq",
            "targetValue": [
                "deduct_2001_3080"
            ],
            "targetType": "start",
            "columnType": "dim",
            "interval": ""
        }
    ],
    "conditions": [
        {
            "conditionIndex": "T1",
            "columnCode": "datae_column_98b2ae8d19",
            "dataSourceCode": "table_1653635662711",
            "authType": 0,
            "isParam": False,
            "compareType": "between",
            "targetValue": [
                "1"
            ],
            "targetType": "hour",
            "columnType": "dim",
            "interval": "day_real"
        },
        {
            "conditionIndex": "T2",
            "columnCode": "datae_column_d77aafa1e7",
            "dataSourceCode": "table_1653635662711",
            "authType": 0,
            "isParam": False,
            "compareType": "le",
            "targetValue": [
                "0.5"
            ],
            "targetType": "number",
            "columnType": "",
            "interval": ""
        }
    ],
    "ruleType": 1,
    "expression": "",
    "dispatchTime": "17:00:00",
    "dispatchType": 2,
    "dispatchDay": [],
    "contactType": [
        "mail"
    ],
    "contacts": {
        "mail": [
            "jefffang@didiglobal.com"
        ],
        "dchatPerson": [],
        "dchatGroup": [],
        "sms": [],
        "phone": []
    },
    "alarmLifted": 0,
    "frequencyControl": 0,
    "status": 1,
    "contactRule": []
}
    
json_str = json.dumps(json_obj)


headers = {
    "Accept": "*/*",
    "Accept-Encoding": "gzip, deflate, br",
    "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8",
    "Cache-Control": "no-cache",
    "Connection": "keep-alive",
    "Content-Type": "application/json;charset=UTF-8",
    "Cookie": "ddc_ticket=d110571c686cc1f80489bc4ab37a0abc000280000; didi_locale=1; username=jefffang",
    "User-Agent": "PostmanRuntime/7.29.0",
}

p_cookies = {
	"ddc_ticket":"d110571c686cc1f80489bc4ab37a0abc000280000",
	"didi_locale":"1",
	"username":"jefffang"
}

r = requests.post('http://bigdata.xiaojukeji.com/report/v2/monitor/config/save',json=json_str,headers=headers)
print(r.content.decode())