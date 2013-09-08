from django.template.loader import get_template
from django.template import Context
from django.http import HttpResponse
import datetime

def stuff(num):
    now = datetime.datetime.now();
    s = [];
    while (num > 0):
        s.append("sugoi");
        num -= 1;

    t = get_template('temp.html');
    c = Context({'message': 'Hello World!', 'cur_time': now, 'sugoilist': s});
    html = t.render(c);    
    return html;

def webpage(request):
    html = stuff(0);
    return HttpResponse(html);

def otherweb(request, num):
    try:
        num = int(num);
    except ValueError:
        raise Http404()

    html = stuff(num);
    return HttpResponse(html);