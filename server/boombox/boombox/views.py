from django.http import HttpResponse
import datetime

def stuff(num):
    now = datetime.datetime.now();
    html = "<p>Hello World!</p>";
    html += "<p>It is now %s.</p>" % now;

    while (num > 0):
        html += "<p>sugoi!</p>";
        num -= 1;
    return html;

def webpage(request):
    html = "<html><body>";

    html += stuff(0);

    html += "</body></html>";
    return HttpResponse(html);

def otherweb(request, num):
    try:
        num = int(num);
    except ValueError:
        raise Http404()

    html = "<html><body>";

    html += stuff(num);

    html += "</body></html>";
    return HttpResponse(html);