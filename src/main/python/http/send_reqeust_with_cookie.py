import requests
import json
from selenium import webdriver

login_url = 'https://me.xiaojukeji.com/user_login?username=fangjie&password=Fj!(**1988&deviceid=null&redirect_uri=http%3A%2F%2Fmis.fangjietaxi.com.cn%2Fauth%2F%3Fapp_id%3D280%26jumpto%3Dhttp%253A%252F%252F%252F%26callback_index%3D0&lcainfo=%7B%22AgentUuid%22%3A%22VjFfMTAwMDAwMV9RRElITjZQUE9CSVE5RjlUVjRHNDNDU1FLRA%22%2C%22AgentVersion%22%3A%222.9.18.0%22%2C%22OS%22%3A%22macOS+11.3.1+(zh_CN)%22%2C%22ComputerName%22%3A%22DIDI-FVFYR220HV2D%22%2C%22LocalUserAccount%22%3A%22fangjie%22%2C%22LcaSsoToken%22%3A%22eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJWakZmTVRBd01EQXdNVjlSUkVsSVRqWlFVRTlDU1ZFNVJqbFVWalJITkRORFUxRkxSQSIsIlRJTUVTVEFNUCI6MTY1NDE1NDQ3OTk4Nn0.QDDygSXD5xuutrkcUzHysEEf7S7I4U8_qrjX9ULqAyV9Yse_X8c0AtAxMD8yrS-FBnY7iVdMkrD3G3U3iqXZgA.04RfAIekySCHNvtEOy3AdFIUl5wPADJpxRVG-7-wwu4%3D%22%2C%22Interfaces%22%3A%5B%7B%22ip%22%3A%22192.168.1.4%22%2C%22mac%22%3A%22a4%3A83%3Ae7%3A07%3A51%3A09%22%2C%22interface%22%3A%22en0%22%7D%2C%7B%22ip%22%3A%22172.28.62.220%22%2C%22mac%22%3A%2200%3A00%3A00%3A00%3A00%3A00%22%2C%22interface%22%3A%22utun2%22%7D%5D%2C%22LCAStatus%22%3A%22%22%2C%22LCAPerm%22%3A%221%22%7D&lcaMark=%7B%22sendTime%22%3A%2219888%3A2022-6-2+15%3A41%3A18%22%2C%22response%22%3A%2219888%3A%7B%5C%22AgentUuid%5C%22%3A%5C%22VjFfMTAwMDAwMV9RRElITjZQUE9CSVE5RjlUVjRHNDNDU1FLRA%5C%22%2C%5C%22AgentVersion%5C%22%3A%5C%222.9.18.0%5C%22%2C%5C%22OS%5C%22%3A%5C%22macOS+11.3.1+(zh_CN)%5C%22%2C%5C%22ComputerName%5C%22%3A%5C%22DIDI-FVFYR220HV2D%5C%22%2C%5C%22LocalUserAccount%5C%22%3A%5C%22fangjie%5C%22%2C%5C%22LcaSsoToken%5C%22%3A%5C%22eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJWakZmTVRBd01EQXdNVjlSUkVsSVRqWlFVRTlDU1ZFNVJqbFVWalJITkRORFUxRkxSQSIsIlRJTUVTVEFNUCI6MTY1NDE1NDQ3OTk4Nn0.QDDygSXD5xuutrkcUzHysEEf7S7I4U8_qrjX9ULqAyV9Yse_X8c0AtAxMD8yrS-FBnY7iVdMkrD3G3U3iqXZgA.04RfAIekySCHNvtEOy3AdFIUl5wPADJpxRVG-7-wwu4%3D%5C%22%2C%5C%22Interfaces%5C%22%3A%5B%7B%5C%22ip%5C%22%3A%5C%22192.168.1.4%5C%22%2C%5C%22mac%5C%22%3A%5C%22a4%3A83%3Ae7%3A07%3A51%3A09%5C%22%2C%5C%22interface%5C%22%3A%5C%22en0%5C%22%7D%2C%7B%5C%22ip%5C%22%3A%5C%22172.28.62.220%5C%22%2C%5C%22mac%5C%22%3A%5C%2200%3A00%3A00%3A00%3A00%3A00%5C%22%2C%5C%22interface%5C%22%3A%5C%22utun2%5C%22%7D%5D%2C%5C%22LCAStatus%5C%22%3A%5C%22%5C%22%2C%5C%22LCAPerm%5C%22%3A%5C%221%5C%22%7D%22%2C%22TimeOut%22%3A%22%22%7D'

# 创建一个session,作用会自动保存cookie
session = requests.session()
# 使用session发起post请求来获取登录后的cookie,cookie已经存在session中
response = session.post(url = login_url)

cookies = response.cookies.get_dict()
print(cookies)
print(response.content.decode())


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
                "_2001_3080"
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
            "fangjie@fangjieglobal.com"
        ],
        "Person": [],
        "Group": [],
        "sms": [],
        "phone": []
    },
    "alarmLifted": 0,
    "frequencyControl": 0,
    "status": 1,
    "contactRule": []
}
    
json_str = json.dumps(json_obj)

login_response = json.loads(response.content.decode())
redirect_url = login_response['redirect']
redirect_response = session.get(redirect_url)



headers = {
    "Content-Type": "application/json;charset=utf-8",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36",
    "Cookie":"=d110571c686cc1f80489bc4ab37a0abc000280000;username=fangjie",
    "Host":""
}

bigdata_response = session.get('http:///dcp/fw/user/preference/v2/get')
print(bigdata_response.content.decode())

p_cookies = {
	"":"d110571c686cc1f80489bc4ab37a0abc000280000",
	"fangjie_locale":"1",
	"username":"fangjie"
}
r = requests.post('http:///report/v2/monitor/config/save',timeout=10,json=json_str,headers=headers)
print(r.content.decode())