require 'rubygems'
require 'sinatra'

client = Mysql2::Client.new(:host => "localhost", :username => "root", :flags => Mysql2::Client::MULTI_STATEMENTS )
result = client.query( 'CALL sp_customer_list( 25, 10 )')
# result now contains the first result set
while ( client.next_result)
    result = client.store_result
    # result now contains the next result set
end


get '/' do
	"Hello from Sinatra on Heroku!"
end

get '/hello/:name' do
	"Hello #{params[:name]}!"
end