from django.conf.urls import patterns, include, url
from boombox.views import webpage, otherweb

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('',
    url(r'^$', webpage),
    url(r'(\d{1,3})\d*/$', otherweb),
    # Examples:
    # url(r'^$', 'boombox.views.home', name='home'),
    # url(r'^boombox/', include('boombox.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    # url(r'^admin/', include(admin.site.urls)),
)
