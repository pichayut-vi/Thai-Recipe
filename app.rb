require 'rubygems'
require 'sinatra'

get '/' do
	"Hello from Sinatra on Heroku!"
end

get '/hello/:name' do
	"Hello #{params[:name]}!"
end