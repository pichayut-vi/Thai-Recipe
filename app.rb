require 'rubygems'
require 'sinatra'

Mysql2::Client.new(
  :host,
  :username,
  :password,
  :port,
  :database,
  :socket = '/path/to/mysql.sock',
  :flags = REMEMBER_OPTIONS | LONG_PASSWORD | LONG_FLAG | TRANSACTIONS | PROTOCOL_41 | SECURE_CONNECTION | MULTI_STATEMENTS,
  :encoding = 'utf8',
  :read_timeout = seconds,
  :write_timeout = seconds,
  :connect_timeout = seconds,
  :reconnect = true/false,
  :local_infile = true/false,
  )

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