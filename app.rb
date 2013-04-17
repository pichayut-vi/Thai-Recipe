require 'rubygems'
require 'sinatra'
require 'mysql2'
require 'json'

#client = Mysql2::Client.new(:host => "localhost", :username => "root", :password => "root", :encoding => "utf8",
#						 :database => "treasurehunter", :socket => "C:/xampp/mysql/mysql.sock")

client = Mysql2::Client.new(:host => "localhost", :username => "root", :password => "root", :encoding => "utf8",
						 :database => "treasurehunter", :socket => "/Applications/MAMP/tmp/mysql/mysql.sock")

get '/' do
	"Hello from Sinatra!"
end

get '/map' do
	res = Array.new
	array = [:id, :username, :session, :time]
	result = client.query("SELECT * FROM loginsessions",:as => :array) #object as array
	result.each do | row |
		res.push(Hash[array.zip(row)])
	end
	return res.to_json
end


