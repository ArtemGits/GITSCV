from django.shortcuts import render

# Create your views here.
#views.py
from login.forms import *
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout
from django.views.decorators.csrf import csrf_protect
from django.shortcuts import render_to_response
from django.shortcuts import redirect
from django.http import HttpResponseRedirect
from django.template import RequestContext
 
@csrf_protect
def register(request):
    if request.method == 'POST':
        form = RegistrationForm(request.POST)
        if form.is_valid():
            user = User.objects.create_user(
            username=form.cleaned_data['username'],
            password=form.cleaned_data['password1'],
            email=form.cleaned_data['email']
            )
            return HttpResponseRedirect('/register/success/')
    else:
        form = RegistrationForm()
    variables = RequestContext(request, {
    'form': form
    })
 
    return render_to_response(
    'registration/register.html',
    variables,
    )
 
def register_success(request):
    return render_to_response(
    'registration/success.html',
    )
 
def logout_page(request):
    logout(request)
    return HttpResponseRedirect('/')
 
@login_required(login_url="/accounts/login/")
def home(request):
    return render_to_response(
    'home.html',
    { 'user': request.user }
    )
def index_page(request):
	return render_to_response('base.html')
def geomoose_guest(request):
	return redirect('http://localhost/geomoose/geomoose_guest.html')


@login_required	(login_url="/accounts/login/")
def geomoose_user(request):
	return redirect('http://localhost/geomoose/geomoose.html')
