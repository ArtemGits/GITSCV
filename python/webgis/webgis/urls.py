"""webgis URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.9/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Import the include() function: from django.conf.urls import url, include
    3. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import include, url
from django.contrib import admin
from login.views import *
urlpatterns = [
    url(r'^admin/', include(admin.site.urls)),
   # url(r'^', 'helloapp.views.home_view'),
   # url(r'^$', 'django.contrib.auth.views.login'),
    url(r'^$', 'login.views.index_page'),
    url(r'^home/$', home),
    url(r'^register/$', register),
    url(r'^register/success/$', register_success),
    url(r'^accounts/login/$', 'django.contrib.auth.views.login'),
    url(r'^/$', logout_page),
    url(r'^geomoose_guest/$', geomoose_guest),
    url(r'^geomoose_user/$', geomoose_user),
    url(r'^geomoose/$',logout_page),
    


]
