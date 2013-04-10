require 'sinatra'

get '/' do
  'Hello world!'
end

#Get parameter
get '/hello/:name' do
  "Hello #{params[:name]}!"
end	